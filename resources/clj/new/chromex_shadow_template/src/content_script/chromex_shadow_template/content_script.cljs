(ns {{namespace}}.content-script
  (:require-macros [chromex.support :refer [runonce]])
  (:require [{{namespace}}.content-script.core :as core]))

(runonce
  (core/init!))
