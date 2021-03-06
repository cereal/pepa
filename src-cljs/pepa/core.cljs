(ns pepa.core
  (:require pepa.style
            pepa.navigation
            pepa.api

            [pepa.data :as data]
            [pepa.preloader :as preloader]
            [pepa.components.root :refer [root-component]]
            [pepa.components.draggable :as draggable]

            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [sablono.core :refer-macros [html]]

            [weasel.repl :as ws-repl]))

(enable-console-print!)

(ws-repl/connect (str "ws://" js/window.location.hostname ":9009")
                 :verbose true
                 :print :console)

;;; Preload Images
(preloader/preload)

(om/root root-component
         data/state
         {:target js/window.document.body
          :shared (merge {}
                         (draggable/shared-data))})
