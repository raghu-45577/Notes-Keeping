import { signOut } from "firebase/auth";
import React from "react";
import { useNavigate } from "react-router-dom";
import { auth } from "../firebase/firebase";
import icon from "../icons/download.png";

function Header() {
  const navigate = useNavigate();
  function signOutHandler() {
    signOut(auth).then(() => {
      navigate("/");
      localStorage.removeItem("user");
    });
  }

  return (
    <div className="d-flex justify-content-around header">
      <div className="d-flex justify-content-start" style={{ width: "48%" }}>
        <img
          src={icon}
          style={{ height: "80%", marginTop: "5px" }}
          alt="icon"
        />
        <span className="name">
          <b>Notes</b>
        </span>
      </div>

      <div className="d-flex justify-content-end" style={{ width: "50%" }}>
        <button
          className="btn btn-danger"
          onClick={() => signOutHandler()}
          style={{ margin: "5px" }}
        >
          Sign out
        </button>
      </div>
    </div>
  );
}

export default Header;
