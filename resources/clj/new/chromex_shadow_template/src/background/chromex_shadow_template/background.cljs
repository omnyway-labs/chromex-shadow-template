(ns {{namespace}}.background
  (:require-macros [chromex.support :refer [runonce]])
  (:require [{{namespace}}.background.core :as core]))

(runonce
  (core/init!))
