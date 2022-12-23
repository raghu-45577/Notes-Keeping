import React, { useEffect, useState } from "react";
import CreateNoteModal from "../modals/CreateNoteModal";
import UpdateNoteModal from "../modals/UpdateNoteModal";
import ViewNoteModal from "../modals/ViewNoteModal";
import NotesService from "../services/NotesService";

function NotesList() {
  const [notes, setNotes] = useState([]);
  const [created, setCreated] = useState(false);
  const [id, setId] = useState();
  const [update, setUpdate] = useState(false);
  const [view, setView] = useState(false);
  const [uid, setUid] = useState();
  const [title, setTitle] = useState("");
  const [fNote, setFNote] = useState([]);
  useEffect(() => {
    let eml = localStorage.getItem("user");
    setUid(eml.substring(0, eml.indexOf("@")));
    NotesService.getNotes(uid).then((res) => {
      setNotes(res.data);
    });
  }, [uid]);

  function addHandler() {
    setCreated(!created);
  }

  function deleteHandler(id) {
    let eml = localStorage.getItem("user");
    setUid(eml.substring(0, eml.indexOf("@")));
    NotesService.deleteNote(id, uid).then((res) => {});
    setNotes(notes.filter((note) => note.id !== id));
  }

  function editHandler(id) {
    setId(id);
    setUpdate(!update);
  }

  function viewHandler(id) {
    setId(id);
    setView(!view);
  }

  const inputHandler = (e) => {
    setTitle(e.target.value);
    if (e.target.value !== "") {
      const filteredNote = notes.filter((item) => {
        return Object.values(item)
          .join("")
          .toLowerCase()
          .includes(e.target.value.toLowerCase());
      });
      setFNote(filteredNote);
    }
  };
  return (
    <div>
      <div className="d-flex justify-content-around" style={{ width: "60%" }}>
        <button
          className="btn btn-primary"
          style={{
            fontSize: "12px",
            marginTop: "60px",
            marginLeft: "30px",
            width: "130px",
            height: "45px",
            marginBottom: "10px",
          }}
          onClick={() => addHandler()}
        >
          Add Note
        </button>
        <div className="search d-flex justify-content-center align-items-center">
          <input
            type="text"
            name="title"
            placeholder="search by title..."
            value={title}
            onChange={(e) => inputHandler(e)}
            style={{
              height: "100%",
              width: "95%",
              border: "none",
              borderRadius: "10px",
              outline: 0,
            }}
          />
          <span className="material-icons" style={{ cursor: "pointer" }}>
            search
          </span>
        </div>
      </div>
      <CreateNoteModal created={created} onclick={() => addHandler()} />
      {id && (
        <UpdateNoteModal
          update={update}
          onclick={() => editHandler()}
          nid={id}
        />
      )}
      {id && (
        <ViewNoteModal view={view} onclick={() => viewHandler()} nid={id} />
      )}

      <center>
        <div className="container cont">
          <div className="row row-cols-3">
            {!title ? (
              notes ? (
                notes.map((note, index) => {
                  return (
                    <div
                      key={index}
                      className="card prop"
                      style={{
                        width: "21rem",
                        margin: "20px",
                        height: "150px",
                      }}
                    >
                      <div className="card-body">
                        <h5
                          className="card-title"
                          style={{
                            textAlign: "left",
                            fontSize: "20px",
                            marginBottom: "15px",
                          }}
                        >
                          <b>{note.title}</b>
                        </h5>
                        <h6 className="card-subtitle mb-2 text-muted desc">
                          {note.description}
                        </h6>

                        <div
                          className="d-flex justify-content-around button"
                          style={{
                            bottom: "0",
                            width: "50%",
                            border: "1px solid black",
                            borderRadius: "10px",
                            marginTop: "20px",
                          }}
                        >
                          <span
                            className="material-icons button point"
                            onClick={() => deleteHandler(note.id)}
                          >
                            delete
                          </span>
                          <span
                            className="material-icons button point"
                            onClick={() => editHandler(note.id)}
                          >
                            edit
                          </span>
                          <span
                            className="material-icons button point"
                            onClick={() => viewHandler(note.id)}
                          >
                            visibility
                          </span>
                        </div>
                      </div>
                    </div>
                  );
                })
              ) : (
                <div></div>
              )
            ) : (
              fNote.map((note, index) => {
                return (
                  <div
                    key={index}
                    className="card prop"
                    style={{
                      width: "21rem",
                      margin: "20px",
                      height: "150px",
                    }}
                  >
                    <div className="card-body">
                      <h5
                        className="card-title"
                        style={{
                          textAlign: "left",
                          fontSize: "20px",
                          marginBottom: "15px",
                        }}
                      >
                        <b>{note.title}</b>
                      </h5>
                      <h6 className="card-subtitle mb-2 text-muted desc">
                        {note.description}
                      </h6>

                      <div
                        className="d-flex justify-content-around button"
                        style={{
                          bottom: "0",
                          width: "50%",
                          border: "1px solid black",
                          borderRadius: "10px",
                          marginTop: "20px",
                        }}
                      >
                        <span
                          className="material-icons button point"
                          onClick={() => deleteHandler(note.id)}
                        >
                          delete
                        </span>
                        <span
                          className="material-icons button point"
                          onClick={() => editHandler(note.id)}
                        >
                          edit
                        </span>
                        <span
                          className="material-icons button point"
                          onClick={() => viewHandler(note.id)}
                        >
                          visibility
                        </span>
                      </div>
                    </div>
                  </div>
                );
              })
            )}
          </div>
        </div>
      </center>
    </div>
  );
}

export default NotesList;
