import { useNavigate } from "react-router-dom"

export default function Srcomp() {
  const navigate = useNavigate();
  const a = () => {
    navigate('/dest', { state: { id: 1, job: '개발자' } });
  }
  return (
    <div>
      <button onClick={a}>컴포넌트 이동</button>
    </div>
  )
}