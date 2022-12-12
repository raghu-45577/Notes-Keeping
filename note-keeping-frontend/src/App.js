import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import NotesList from "./components/NotesList";
import CreateNoteModal from "./modals/CreateNoteModal";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={[
            <NotesList key={3} />,
            <Header key={1} />,
            <Footer key={2} />,
          ]}
        />
        <Route path="/newNote" element={<CreateNoteModal />} />
        {/* <Route path="/notes" element={<NotesList />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
