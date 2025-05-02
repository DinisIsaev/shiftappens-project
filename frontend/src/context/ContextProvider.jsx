import { useState, createContext, useContext } from "react";

const StateContext = createContext(
    {
        currentUser: null,
        setCurrentUser: () => {},
        token: null,
        setToken: () => {},
    }
);

export const ContextProvider = ({ children }) => {
    const [currentUser, setCurrentUser] = useState(null);
    const [token, _setToken] = useState(null);

    const setToken = (newToken) => {
        _setToken(newToken);
        if (newToken) {
            localStorage.setItem("token", newToken);
        }
        else {
            localStorage.removeItem("token");
        }
    }
    return (
        <StateContext.Provider value={{ currentUser, setCurrentUser, token, setToken }}>
            {children}
        </StateContext.Provider>
    );
}

export const useStateContext = () => useContext(StateContext);