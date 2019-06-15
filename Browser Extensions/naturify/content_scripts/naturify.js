(function() {
    /**
     * Check and set a global guard variable.
     * If this content script is injected into the same page again,
     * it will do nothing next time.
     */
    if (window.hasRun) {
        return;
    }
    window.hasRun = true;

    /**
     * Given a URL to a nature image, remove all exisiting nature, then
     * create an style an IMG node pointing to
     * that image, then insert the node into the document.
     */
    function insertNature(natureURL) {
        removeExistingNature();
        let natureImage = document.createElement("img");
        natureImage.setAttribute("src", natureURL);
        natureImage.style.height = "100vh";
        natureImage.className = "naturify-image";
        document.body.appendChild(natureImage);
    }

    /**
     * Remove every nature from the page.
     */
    function removeExistingNature() {
        let existingNature = document.querySelectorAll(".naturify-image");
        for (let nature of existingNature) {
            nature.remove();
        }
    }

    /**
     * Listen for messages from the background script.
     * Call "naturify()" or "reset()".
     */
    browser.runtime.onMessage.addListener((message) => {
        if (message.command === "naturify") {
            insertNature(message.natureURL);
        } else if (message.command === "reset") {
            removeExistingNature();
        }
    });

})();
