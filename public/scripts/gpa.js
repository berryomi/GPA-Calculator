"use strict";

const myAppObj = new Vue({
    el: "#gpaApp",
    data: {
         grades: [],
         selectedGrade: null,
         selectedGrade2: null,
         selectedGrade3: null,
         selectedGrade4: null,
         selectedGrade5: null,
         selectedGrade6: null,

         nameInput: '',
         unitInput: '',

         nameInput2: '',
         unitInput2: '',

         nameInput3: '',
         unitInput3: '',

         nameInput4: '',
         unitInput4: '',

         nameInput5: '',
         unitInput5: '',

         nameInput6: '',
         unitInput6: '',

         cgpaInput: '',
         totalCreditInput: '',

         termGPAOutput: '',
         cgpaOutput: '',
    }
});

window.addEventListener("load", function() {
    var btnCalc = document.getElementById("calcButton");

    var termGPATotal = document.getElementById("termGPAOutput");
    var cgpaTotal = document.getElementById("cgpaOutput");

    btnCalc.onclick = function() {

        if (myAppObj.selectedGrade != null && myAppObj.nameInput != null && myAppObj.unitInput != null) {
                createCourse(myAppObj.nameInput, myAppObj.unitInput, myAppObj.selectedGrade);
        }
        if (myAppObj.selectedGrade2 != null && myAppObj.nameInput2 != null && myAppObj.unitInput2 != null) {
                createCourse(myAppObj.nameInput2, myAppObj.unitInput2, myAppObj.selectedGrade2);
        }
        if (myAppObj.selectedGrade3 != null && myAppObj.nameInput3 != null && myAppObj.unitInput3 != null) {
                createCourse(myAppObj.nameInput3, myAppObj.unitInput3, myAppObj.selectedGrade3);
        }
        if (myAppObj.selectedGrade4 != null && myAppObj.nameInput4 != null && myAppObj.unitInput4 != null) {
                createCourse(myAppObj.nameInput4, myAppObj.unitInput4, myAppObj.selectedGrade4);
        }
        if (myAppObj.selectedGrade5 != null && myAppObj.nameInput5 != null && myAppObj.unitInput5 != null) {
                createCourse(myAppObj.nameInput5, myAppObj.unitInput5, myAppObj.selectedGrade5);
        }
        if (myAppObj.selectedGrade6 != null && myAppObj.nameInput6 != null && myAppObj.unitInput6 != null) {
                createCourse(myAppObj.nameInput6, myAppObj.unitInput6, myAppObj.selectedGrade6);
        }

        if (myAppObj.cgpaInput != null && myAppObj.totalCreditInput != null) {
                createStudent(myAppObj.cgpaInput, myAppObj.totalCreditInput, null);
        }



    };

});

$(document).ready(function() {
    loadGrades();
});

function loadGrades() {
    axios.get('/api/grades', {})
      .then(function (response) {
        console.log(response);
        myAppObj.grades = response.data;
      })
      .catch(function (error) {
        console.log(error);
      });
}

function createCourse(name, units, grade) {
    axios.post('/api/addcourse', {
            name: name,
            units: units,
            grade: grade
          })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
}

function createStudent(cgpa, totalUnits, courses) {
    axios.post('/api/addstudent', {
             cgpa: cgpa,
             totalUnits: totalUnits,
             courses: courses
           })
           .then(function (response) {
             console.log(response);
             myAppObj.termGPAOutput = response.data.currentTerm;
             myAppObj.cgpaOutput = response.data.cgpa;
           })
           .catch(function (error) {
             console.log(error);
           });
}

function reset() {
    axios.get('/api/reset', {})
           .then(function (response) {
              console.log(response);
           })
           .catch(function (error) {
              console.log(error);
           });
}

