firebase.auth().onAuthStateChanged(function(user) {
  if (user) {
    // User is signed in.
  } else {
    var form = document.createElement("form");
    form.method = "POST";
    form.action = "/logout";
    document.body.appendChild(form);
    form.submit();
  }
});

$(document).ready(function() {
//   var user = firebase.auth().currentUser;

//   if (user) {
//     // User is signed in.
//   } else {
//     firebase.auth().signOut();
//   }
  $("#logoutBtn").click(function() {
    firebase.auth().signOut();
  });
});
