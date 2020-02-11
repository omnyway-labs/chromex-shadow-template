(ns clj.new.chromex-shadow
  (:require [clj.new.templates :refer [renderer project-data ->files]]))

(defn chromex-shadow
  "FIXME: write documentation"
  [name]
  (let [render (renderer "chromex-shadow")
        data   (project-data name)]
    (println "Generating fresh 'clj new' chromex-shadow project.")
    (->files data
             ["deps.edn" (render "deps.edn" data)]
             ["src/{{nested-dirs}}/foo.clj" (render "foo.clj" data)])))
