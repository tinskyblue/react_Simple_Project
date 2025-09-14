import { useEffect, useState }  from "react";
import { getUsers } from "../api/api";

function UserList() {
  const [users, setUsers] = useState([]);
  
  useEffect(() => {
    getUsers().then(res => setUsers(res.data));
  },[]);

  return (
    <div>
      <h2>유저 목록</h2>
      <ul>
        {users.map(u => <li key={u.id}>{u.username} ({u.email})</li>)}
      </ul>
    </div>
  );
}

export default UserList;