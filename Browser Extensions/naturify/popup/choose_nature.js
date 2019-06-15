/**
 * CSS to hide everything on the page,
 * except for elements that have the "naturify-image" class.
 */
const hidePage = `body > :not(.naturify-image) {
                    display: none;
                 }`;

/**
 * Listen for clicks on the buttons, and send the appropriate message to
 * the content script in the page.
 */
function listenForClicks() {
    document.addEventListener("click", (e) => {

        /**
         * Given the name of a nature, get the URL to the corresponding image.
         */
        function natureNameToURL(natureName) {
            switch (natureName) {
                case "Waterfall":
                    return browser.extension.getURL("nature/waterfall.jpg");
                case "Snow":
                    return browser.extension.getURL("nature/snow.jpg");
                case "Nightfall":
                    return browser.extension.getURL("nature/nightfall.jpg");
            }
        }

        /**
         * Insert the page-hiding CSS into the active tab,
         * then get the nature URL and
         * send a "naturify" message to the content script into the active tab.
         */
        function naturify(tabs) {
            browser.tabs.insertCSS({code: hidePage}).then(() => {
                let url = natureNameToURL(e.target.textContent);
                browser.tabs.sendMessage(tabs[0].id, {
                    command: "naturify",
                    natureURL: url
                });
            });
        }

        /**
         * Remove the page-hiding CSS from the active tab,
         * send a "reset" message to the content script in the active tab.
         */
        function reset(tabs) {
            browser.tabs.removeCSS({code: hidePage}).then(() => {
                browser.tabs.sendMessage(tabs[0].id, {
                    command: "reset",
                });
            });
        }

        /**
         * Just log the error to the console.
         */
        function reportError(error) {
            console.error(`Could not naturify: ${error}`);
        }

        /**
         * Get the active tab,
         * then call "naturify()" or "reset()" as appropriate.
         */
        if (e.target.classList.contains("nature")) {
            browser.tabs.query({active: true, currentWindow: true})
                .then(naturify)
                .catch(reportError);
        }
        else if (e.target.classList.contains("reset")) {
            browser.tabs.query({active: true, currentWindow: true})
                .then(reset)
                .catch(reportError);
        }
    });
}

/**
 * There was an error executing the script.
 * Display the popup's error message, and hide the normal UI.
 */
function reportExecuteScriptError(error) {
    document.querySelector("#popup-content").classList.add("hidden");
    document.querySelector("#error-content").classList.remove("hidden")
    console.error(`Failed to execute naturify content script: ${error.message}`);
}

/**
 * When the popup loads, inject a content script into the active tab,
 * and add a click handler.
 * If we couldn't inject the script, handle the error.
 */
browser.tabs.executeScript({file: "/content_scripts/naturify.js"})
.then(listenForClicks)
.catch(reportExecuteScriptError);
