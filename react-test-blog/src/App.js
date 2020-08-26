import React from "react";
import "./App.css";
import Dashboard from "./components/Dashboard";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./header/Header";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddPost from "./app/AddPost";

function App() {
  return (
    <Router>
      <div className="App">
        <Route exact path="/addPost" component={AddPost} />
        <Header />
        <Dashboard />
      </div>
    </Router>
  );
}

export default App;