(ns {{namespace}}.popup
  (:require-macros [chromex.support :refer [runonce]])
  (:require [{{namespace}}.popup.core :as core]))

(runonce
  (core/init!))
