"use strict";
(function(){
    const btnOpenDialog = document.querySelector("#btnOpenDialog");
    if(btnOpenDialog) {
        btnOpenDialog.addEventListener("click", () => {
            const dialog = document.querySelector("#dialog");
            dialog.showModal();
        });
    }
})();