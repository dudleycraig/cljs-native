(ns za.org.functional.screens.home
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text Image Button StyleSheet]]
            ["tailwind-rn" :as tailwind]
 
            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]
            
            [za.org.functional.providers.app-provider :as app-provider]
           
            [za.org.functional.components.screen-container :refer [ScreenContainer]]
            [za.org.functional.components.profile-picture :refer [ProfilePicture]]))

(defnc Home [{:keys [navigation route] :as props}]
  (let [tw (tailwind/useTailwind)
        app-context (app-provider/use-context)
        page (. route -name)
        paragraph-style (tw "clear-both text-center bg-black-100 p-1 w-4/5")]
    ($ ScreenContainer
      ($ ProfilePicture)
      ($ Text
         {:style paragraph-style}
         "My experience is deep. Currently emphasizing a Linux-based, Clojure/Clojurescript or Node.js/Typescript full-stack. Applications are rich in WebGL and GIS context, coupled with real-time, stitched API resources.")
      ($ Text
         {:style paragraph-style}
         "Documentation, Linting, Unit/Integration testing, and Dockerization ... CI development piped \"555\"."))))






