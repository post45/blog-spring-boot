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
        <Header />
        <Route exact path="/dashboard" component={Dashboard} />
        <Route exact path="/addPost" component={AddPost} />
      </div>
    </Router>
  );
}

export default App;
