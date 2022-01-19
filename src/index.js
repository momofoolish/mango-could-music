import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import { BrowserRouter as Router } from "react-router-dom";
import TodoModel from "./models/TodoModel";

const store = new TodoModel();

ReactDOM.render(
    <Router>
        <App store={store} />
    </Router>
    , document.getElementById('root')
);
