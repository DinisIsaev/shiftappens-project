import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import MomentCard  from './components/MomentCard'
import ProfilePage from './components/ProfilePage'
import AlbumCard from './components/AlbumCard'
import {BrowserRouter, Routes, Route} from 'react-router-dom'

function App() {
  return(
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ProfilePage/>}/>
        <Route path="/moment" element={<MomentCard/>}/>
        <Route path="/album" element={<AlbumCard/>}/>
      </Routes>
    </BrowserRouter>
  );

}

export default App
