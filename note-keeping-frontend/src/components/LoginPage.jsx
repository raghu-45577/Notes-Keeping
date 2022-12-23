import React from "react";
import GoogleButton from "react-google-button";
import { GoogleAuthProvider, signInWithPopup } from "firebase/auth";
import { auth } from "../firebase/firebase";
import { useNavigate } from "react-router-dom";
import NotesService from "../services/NotesService";

function LoginPage() {
  const navigate = useNavigate();

  function signInHandler() {
    const provider = new GoogleAuthProvider();
    signInWithPopup(auth, provider).then(() => {
      const user = auth.currentUser;
      navigate("/notes");
      NotesService.addUser(user.email);
      localStorage.setItem("user", user.email);
    });
  }

  return (
    <div className="login">
      <GoogleButton onClick={() => signInHandler()}></GoogleButton>
    </div>
  );
}

export default LoginPage;
