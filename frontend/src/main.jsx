import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './styles/momentcard.css'
import './styles/profilepage.css'
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
