(ns clj.new.chromex-shadow-template
  "Generate a chromex / shadow-cljs chrome extension project."
  (:require [clj.new.templates :refer [renderer project-data project-name sanitize sanitize-ns name-to-path raw-resourcer ->files]]))

(defn chromex-shadow-template
  "Generate a chromex based chrome extension"
  [name & args]
  (let [features (into #{} args)
        render (renderer "chromex-shadow-template")
        raw (raw-resourcer "chromex-shadow-template")
        group-in-ns? (features "+group-in-ns")
        base-data (project-data name)
        namespace (if-not group-in-ns?
                    {:namespace (project-name name)}
                    {:namespace (sanitize-ns name)})
        nested-dirs (if-not group-in-ns? {:nested-dirs (name-to-path (:namespace namespace))})
        data   (merge base-data namespace nested-dirs)]
    (println "Generating a project called"
             (project-name name)
             "based on the 'chromex-shadow' template.")
    (println "Data: " data)
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["deps.edn" (render "deps.edn" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["package.json" (render "package.json" data)]
             ["README.md" (render "README.md" data)]
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)]

             ["scripts/_config.sh" (render "scripts/_config.sh")]
             ["scripts/clean.sh" (render "scripts/clean.sh")]
             ["scripts/release.sh" (render "scripts/release.sh")]
             ["scripts/package.sh" (render "scripts/package.sh" data)]

             ["resources/unpacked/manifest.edn" (render "resources/unpacked/manifest.edn" data)]
             ["resources/unpacked/popup.html" (raw "resources/unpacked/popup.html")]
             ["resources/unpacked/images/icon128.png" (raw "resources/unpacked/images/icon128.png")]
             ["resources/unpacked/images/icon16.png" (raw "resources/unpacked/images/icon16.png")]
             ["resources/unpacked/images/icon19.png" (raw "resources/unpacked/images/icon19.png")]
             ["resources/unpacked/images/icon38.png" (raw "resources/unpacked/images/icon38.png")]
             ["resources/unpacked/images/icon48.png" (raw "resources/unpacked/images/icon48.png")]

             ["src/background/{{nested-dirs}}/background.cljs"
              (render "src/background/chromex_shadow_template/background.cljs" data)]
             ["src/background/{{nested-dirs}}/background/core.cljs"
              (render "src/background/chromex_shadow_template/background/core.cljs" data)]
             ["src/background/{{nested-dirs}}/background/storage.cljs"
              (render "src/background/chromex_shadow_template/background/storage.cljs" data)]
             ["src/content_script/{{nested-dirs}}/content_script.cljs"
              (render "src/content_script/chromex_shadow_template/content_script.cljs" data)]
             ["src/content_script/{{nested-dirs}}/content_script/core.cljs"
              (render "src/content_script/chromex_shadow_template/content_script/core.cljs" data)]
             ["src/popup/{{nested-dirs}}/popup.cljs"
              (render "src/popup/chromex_shadow_template/popup.cljs" data)]
             ["src/popup/{{nested-dirs}}/popup/core.cljs"
              (render "src/popup/chromex_shadow_template/popup/core.cljs" data)]


             ;; These will go away once these hacks are no longer needed
             ["src/shadow_hacks/shadow/build/compiler.clj"
              (raw "src/shadow_hacks/shadow/build/compiler.clj")]
             ["src/shadow_hacks/shadow/build/output.clj"
              (raw "src/shadow_hacks/shadow/build/output.clj")]
             ["src/shadow_hacks/shadow/build/targets/chrome_extension.clj"
              (raw "src/shadow_hacks/shadow/build/targets/chrome_extension.clj")]
             ["src/shadow_hacks/shadow/build/targets/react_native.clj"
              (raw "src/shadow_hacks/shadow/build/targets/react_native.clj")])))
