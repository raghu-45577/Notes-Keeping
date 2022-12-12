import React from "react";
import icon from "../icons/download.png";

function Header() {
  return (
    <div className="d-flex justify-content-around header">
      <div className="d-flex justify-content-start">
        <img
          src={icon}
          style={{ height: "80%", marginTop: "5px" }}
          alt="icon"
        />
        <span className="name">
          <b>Notes</b>
        </span>
      </div>
    </div>
  );
}

export default Header;
