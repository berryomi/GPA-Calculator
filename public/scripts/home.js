"use strict";

const myAppObj = new Vue({
    el: "#HomeApp",
    data: {
        appName: "...",
        authorName: "...",
    }
});

// Load data from server
$(document).ready(function() {
    axios.get('api/name', {})
      .then(function (response) {
        console.log(response);
        myAppObj.appName = response.data.appName;
        myAppObj.authorName = response.data.authorName;
      })
      .catch(function (error) {
        console.log(error);
      });
});

