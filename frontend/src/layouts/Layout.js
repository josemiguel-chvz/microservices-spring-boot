import Menu from "../components/Menu";
// import React, { useState, useEffect } from "react";



// const BASE_URL = 'http://localhost:8000/api'


const Layout = ({children}) => {
    // const [show, setShow] = useState(false);
    // const [newNotification, setNewNotification] = useState({});

    // const handleNotificationStatus = (status) => {
    //   setShow(status);
    // }

    // const listenNotifications = () => {
    //   var channel = pusher.subscribe('notification_channel');
    //   channel.bind("new_notification", function (data) {
    //     setShow(true);
    //     setNewNotification(data);
    //   });
    // }

    // useEffect(() => {
    //   listenNotifications();
    //   //eslint-disable-next-line react-hooks/exhaustive-deps
    // }, []);

    return (
        <>
            <Menu />
            <main>{children}</main>
        </>
    );
};

export default Layout;