(ns clj.new.chromex-shadow
  "Generate a chromex / shadow-cljs chrome extension project."
  (:require [clj.new.templates :refer [renderer project-data ->files]]))

(defn chromex-shadow
  "Generate a chromex based chrome extension"
  [name]
  (let [render (renderer "chromex-shadow")
        data   (project-data name)]
    (println "Generating a project called"
             (project-name name)
             "based on the 'amplitude' template.")
    (println "Data: " data)
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["deps.edn" (render "deps.edn" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["package.json" (render "package.json" data)]
             ["readme.md" (render "readme.md" data)]
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)]

             ["scripts/_config.sh" (render "scripts/_config.sh")]
             ["scripts/clean.sh" (render "scripts/clean.sh")]
             ["scripts/release.sh" (render "scripts/release.sh")]
             ["scripts/package.sh" (render "scripts/package.sh" data)]

             ["resources/unpacked/manifest.edn" (render "resources/unpacked/manifest.edn" data)]
             ["resources/unpacked/popup.html" (render "resources/unpacked/popup.html")]
             ["resources/unpacked/images/icon128.png" (render "resources/unpacked/images/icon128.png")]
             ["resources/unpacked/images/icon16.png" (render "resources/unpacked/images/icon16.png")]
             ["resources/unpacked/images/icon19.png" (render "resources/unpacked/images/icon19.png")]
             ["resources/unpacked/images/icon38.png" (render "resources/unpacked/images/icon38.png")]
             ["resources/unpacked/images/icon48.png" (render "resources/unpacked/images/icon48.png")]

             ["src/background/{{nested-dirs}}/background.cljs"
              (render "src/background/chromex_shadow/background.cljs")]
             ["src/background/{{nested-dirs}}/background/core.cljs"
              (render "src/background/chromex_shadow/background/core.cljs")]
             ["src/background/{{nested-dirs}}/background/storage.cljs"
              (render "src/background/chromex_shadow/background/storage.cljs")]
             ["src/content_script/{{nested-dirs}}/content_script.cljs"
              (render "src/content_script/chromex_shadow/content_script.cljs")]
             ["src/content_script/{{nested-dirs}}/content_script/core.cljs"
              (render "src/content_script/chromex_shadow/content_script/core.cljs")]
             ["src/popup/{{nested-dirs}}/popup.cljs"
              (render "src/popup/chromex_shadow/popup.cljs")]
             ["src/popup/{{nested-dirs}}/popup/core.cljs"
              (render "src/popup/chromex_shadow/popup/core.cljs")]


             ;; These will go away once these hacks are no longer needed
             ["src/shadow_hacks/shadow/build/compiler.clj"
              (render "src/shadow_hacks/shadow/build/compiler.clj")]
             ["src/shadow_hacks/shadow/build/output.clj"
              (render "src/shadow_hacks/shadow/build/output.clj")]
             ["src/shadow_hacks/shadow/build/targets/chrome_extension.clj"
              (render "src/shadow_hacks/shadow/build/targets/chrome_extension.clj")]
             ["src/shadow_hacks/shadow/build/targets/react_native.clj"
              (render "src/shadow_hacks/shadow/build/targets/react_native.clj")])))
