import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './styles/momentcard.css'
import './styles/profilepageweb.css'
import './styles/profilepagephone.css'
import './styles/albumcard.css'
import './styles/sortbyalbumspart.css'
import App from './App.jsx'
import { ContextProvider } from './context/ContextProvider.jsx'


createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ContextProvider>
      <App />
    </ContextProvider>
  </StrictMode>,
)
