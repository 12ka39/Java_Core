import About from "./components/About"
import Hello from "./components/Hello"
import { Routes, Route } from "react-router-dom"
import Srcomp from "./components/Srcomp"
import DestComp from "./components/DestComp"
import NotFound from "./components/NotFound"
import Join from "./components/join"
import Login from "./components/Login"
import Info from "./components/Info"

export default function Router() {
  return (
    <Routes>
      <Route path="/userhome" element={<Hello />} />
      <Route path="/about/:username" element={<About />} />
      <Route path="/src" element={<Srcomp />} />
      <Route path="/dest" element={<DestComp />} />
      <Route path="/member/join" element={<Join />} />
      <Route path="/member/login" element={<Login />} />
      <Route path="/member/info" element={<Info />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
  )
}