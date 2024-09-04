import axios from "axios";
import { useEffect, useState } from "react";

export default function Info() {
  const token = localStorage.getItem('token');
  const [dto, setDto] = useState({});
  const { id, pwd, type } = dto;
  //컴포넌트가 랜더링 할때마다 실행되는 함수
  //맨 처음 한번만 실행하려면, 두 번째 파람을 빈 배열로
  useEffect(() => {
    axios.get('http://localhost:8081/auth/meminfo', { headers: { token: token } })
      .then(function (res) {
        if (res.status === 200) {
          setDto(res.data.dto);
        } else {
          alert('비정상 응답');
        }
      })
  }, []);
  return (
    <div>
      <h2>my info</h2>
      id:{id}<br />
      pwd:{pwd}<br />
      type:{type}<br />
    </div>
  )
}