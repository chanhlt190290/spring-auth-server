var config = {
    scopes: [
        "email",
        "profile",
        "https://www.googleapis.com/auth/calendar"
    ],
    discoveryDocs: [
        "https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"
    ]
};
firebase.initializeApp(config);
