firebase.auth().onAuthStateChanged(function (user) {
  if (user) {
    login(user);
  } else {
    var provider = new firebase.auth.GoogleAuthProvider();
    provider.addScope(config.scopes.join(" "));
    provider.clientID = config.clientId;
    provider.discoveryDocs = config.discoveryDocs;
    provider.apiKey = config.apiKey;

    firebase
      .auth()
      .signInWithPopup(provider)
      // .then(function(result) {
      //   var user = result.user;
      //   login(user);
      // })
      .catch(function (error) {
        console.log(error);
      });
  }
});

function login(user) {
  firebase
    .auth()
    .currentUser.getIdToken( /* forceRefresh */ true)
    .then(function (idToken) {
      var form = document.createElement("form");
      var element1 = document.createElement("input");
      var element2 = document.createElement("input");
      var element3 = document.createElement("input");

      element1.style.visibility = "hidden";
      element2.style.visibility = "hidden";
      element3.style.visibility = "hidden";

      form.method = "POST";
      form.action = "/login";

      element1.value = idToken;
      element1.name = "username";
      form.appendChild(element1);

      element2.value = user.email;
      element2.name = "password";
      form.appendChild(element2);

      element3.value = getUrlParameter('from');
      element3.name = "from";
      form.appendChild(element3);

      document.body.appendChild(form);

      form.submit();
    })
    .catch(function (error) {
      console.log(error);
    });
}

var getUrlParameter = function getUrlParameter(sParam) {
  var sPageURL = decodeURIComponent(window.location.search.substring(1)),
      sURLVariables = sPageURL.split('&'),
      sParameterName,
      i;

  for (i = 0; i < sURLVariables.length; i++) {
      sParameterName = sURLVariables[i].split('=');

      if (sParameterName[0] === sParam) {
          return sParameterName[1] === undefined ? true : sParameterName[1];
      }
  }
  return null;
};
