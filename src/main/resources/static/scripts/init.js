var config = {
    apiKey: "AIzaSyD-EFzXKF4uELsQiI1smzv5FtiavfkQF4E",
    authDomain: "test-app-fd08f.firebaseapp.com",
    databaseURL: "https://test-app-fd08f.firebaseio.com",
    projectId: "test-app-fd08f",
    storageBucket: "test-app-fd08f.appspot.com",
    messagingSenderId: "1031328655061",
    clientId: '682572018798-4rulmci9ecq7h6nmp2ljo3v3doomaq88.apps.googleusercontent.com',
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
