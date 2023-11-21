(ns example.store.contracts
  (:require
   [clojure.spec.alpha :as s]))

(def Contracts
  {:full-time {:name "full-time" :description "Full-time contracts are offered to permanent employees who work a full workweek, usually 35 hours or more. These contracts usually include information about benefits, paid holidays, vacation time, sick time and retirement plans. Even further, some full-time contracts present new employees with opportunities for other benefits, like professional development opportunities or workplace perks. Full-time contracts are almost always written contracts since they include many components, and employers normally want to be thorough and clear when offering such an extensive agreement."}
   :part-time {:name "part-time" :description "Part-time contracts are extended to employees who work a reduced number of hours compared to full-time employees. Typically, part-time contracts are offered to those who serve less than 35 hours per week and often include some of the same stipulations and protections as full-time contracts. Many part-time schedules detail the employee's flexibilities, weekly schedule and rate of pay. However, it is important to note that part-time contracts usually do not include information regarding insurance, salary or PTO—all benefits typically reserved for full-time employees."}
   :zero-hour {:name "zero-hour" :description "Zero-hour contracts are offered to employees who work irregularly or only when work is available. In zero-hour agreements, an employer agrees, in writing or verbally, that they will offer work when it is available, and an employee agrees to work such shifts or remain on call for availability purposes. Zero-hour contracts commonly specify that an employee will work a minimum amount of hours or shifts per month—a number set by the employer in most cases—and that the employee holds the right to refuse any work assignments that may be inopportune.\nZero-hour contracts are often used to hire temporary employees, such as day laborers or babysitters. Unlike full-time and part-time contracts, though, zero-hour contracts do not include information about the standard rate of pay, regular scheduling or benefits, as zero-hour employees are not typically offered such protections."}
   :casual {:name "casual" :description "Casual contracts are usually extended to employees who work on a seasonal or temporary basis. Through casual contracts, employers typically outline that they will only pay employees for completed work and that the company isn't required to offer a minimum amount of shifts or work hours. In addition, such contracts sometimes state that employees are not mandated to take any shifts or work hours offered.\nCasual contracts offer both employees and employers flexibility in their agreement. However, they are typically only used to specify short-term employment relationships that may or may not be renewed after the duration of employment expires."}
   :freelance {:name "freelance" :description "A freelance contract is typically offered to an employee hired to complete a specific project, such as designing a website, writing an article, taking photos or doing home renovations. Freelance contracts outline the limitations of hours, project details, salary and payment terms. These contracts protect freelancers from receiving late payments or from any project-related challenges that may occur. Freelance contracts do not often include information about benefits like insurance or PTO, as freelancers are usually considered self-employed and sometimes even work other full-time jobs."}
   :fixed-term {:name "fixed-term" :description "A fixed-term contract is a highly specific and written contract extended to employees who only work for a set amount of time or until they complete a specific task. Fixed-term contracts are commonplace for temporary or contract workers who may take over a job for a specified amount of time or help an organization fill a gap during a time of need.\nFixed-term employees often receive the same benefits and protections as other full-time or part-time employees during their employment tenure, which can be detailed in the contract. Additionally, many fixed-term contracts can lead to permanent contracts once they are up for renewal."}})

(s/def ::key keyword?)
(s/def ::name string?)
(s/def ::description string?)
(s/def ::contract (s/keys :req-un [::name ::description]
                          :opt-un []))
(s/def ::contracts (s/map-of ::key ::contract))

(comment
  (let [Contract-1 {:name "contract-1 name" :description "contract-1 description."}
        Contract-2 {:name "contract-2 name" :description "contract-2 description."}
        Contract-3 {:name "contract-3 name" :description "contract-3 description."}
        Contracts  {:contract-1 Contract-1
                    :contract-2 Contract-2
                    :contract-3 Contract-3}]
    (and
      (s/explain ::contract Contract-1)
      (s/explain ::contracts Contracts))))

