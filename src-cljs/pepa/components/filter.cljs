(ns pepa.components.filter
  (:require [om.core :as om :include-macros true]
            [sablono.core :refer-macros [html]]
            [clojure.string :as s]

            [pepa.navigation :as nav]
            [pepa.components.logo :as logo]))

(defrecord Search [tags sort-key sort-order])

(defn search-field [search owner _])
