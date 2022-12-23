import axios from "axios";

const NOTES_BASE_URL = "http://localhost:8080/app/v1";

class NotesService {
  addUser(user) {
    return axios.post(NOTES_BASE_URL + "/user", user);
  }

  getUser(id) {
    return axios.get(NOTES_BASE_URL + "/user/" + id);
  }
  getNotes(uid) {
    return axios.get(NOTES_BASE_URL + "/user/" + uid + "/notes");
  }

  createNote(note, uid) {
    return axios.post(NOTES_BASE_URL + "/user/" + uid + "/notes", note);
  }

  updateNote(note, uid, id) {
    return axios.put(NOTES_BASE_URL + "/user/" + uid + "/notes/" + id, note);
  }

  deleteNote(id, uid) {
    return axios.delete(NOTES_BASE_URL + "/user/" + uid + "/notes/" + id);
  }

  getNoteById(id, uid) {
    return axios.get(NOTES_BASE_URL + "/user/" + uid + "/notes/" + id);
  }

  getNoteByTitle(title, uid) {
    return axios.get(NOTES_BASE_URL + "/user/" + uid + "/notes/" + title);
  }
}

export default new NotesService();
