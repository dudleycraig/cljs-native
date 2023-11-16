(ns example.providers.app-provider
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text StyleSheet Button]]

            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]
            
            [example.contexts.app-context :refer [AppContext]]))

(defnc AppProvider [{:keys [children] :as props}]
  (let [[pages set-pages]   (hh/use-state [])
        add-page            (hh/use-callback [set-pages] #(set-pages (conj pages %)))
        remove-page         (hh/use-callback [set-pages] (fn [page] (set-pages (filter #(not= (get % :name) (get page :name)) pages))))]
    (hc/provider
      {:context AppContext 
       :value {:pages pages :add-page add-page :remove-page remove-page}}
      children)))

