import {useContext, useEffect} from "react";
import {AuthContext} from "../../Context/AuthProvider";
import {useNavigate} from "react-router-dom";

function Logout() {

    const { auth, setAuth } = useContext(AuthContext);

    const navigate = useNavigate();

    const logout = () => {

        localStorage.removeItem("accessToken");
        localStorage.removeItem("id");

        alert(auth + "님, 성공적으로 로그아웃 됐습니다 🔒");
        setAuth(null);

        navigate("/");
    };

    useEffect(() => {
        logout();
    }, []);

}

export default Logout;