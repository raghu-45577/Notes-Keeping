// Import the functions you need from the SDKs you need
// import * as firebase from "firebase";
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
// import { getFirestore } from "firebase/firestore";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyD7tbHv-sN0aDgDcFAYsc91INW3pkGhnmw",
  authDomain: "keep-note-b9d28.firebaseapp.com",
  projectId: "keep-note-b9d28",
  storageBucket: "keep-note-b9d28.appspot.com",
  messagingSenderId: "39368110047",
  appId: "1:39368110047:web:29e9d6bdb749d4e61b5e6a",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
