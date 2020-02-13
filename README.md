# chromex-shadow-template

Use `seancorfield/clj-new` to create a basic project for creating a Chrome
Extension using [Chromex](https://github.com/binaryage/chromex), Clojurescript, and Shadow-Cljs. 

It is based on the example code from [Chromex Examples](https://github.com/binaryage/chromex/tree/master/examples/shadow)

## Usage

### Set up an alias for clj-new 

In your `.clojure/deps.edn`:

```clj
    {:aliases
     {:new {:extra-deps {seancorfield/clj-new
                         {:mvn/version "0.8.6"}}
            :main-opts ["-m" "clj-new.create"]}}
     ...}
```

### Generate the project from the chromex-shadow-template git repo

Unfortunately there doesn't seem a way to just get the "latest". You need to specify the full SHA in the git/url:

```
clj -A:new  https://github.com/omnyway-labs/chromex-shadow-template@c390fee6176248d6d589167b22f7d1608269da74 omnyway-labs/test-project
```

> Don't use the SHA shown above. You have to look up on the repo and get the
> latest SHA or the SHA of a release (if there is one)

### Generate the project from a local git clone of the chromex-shadow-template repo

As an alternative, you can clone the chromex-shadow-template repo locally and use it locally

After you cloned the repo to your local disk:

```
clj -A:new  <path-to-chromex-shadow-template repo>::chromex-shadow-template omnyway-labs/test-project
```
### Simple Project Namespace by Default

By default the `namespace` and the `nested-paths` will be based on the sanitized project `name`
only. It will not include the `group` portion that is specified on the command
line.

If you used `omnyway-labs/test-project` on the command line, then by default the
`namespace` and `nested-path` under `src` will be `test_project`. 

(Javascript doesn't allow dashes so dashes are converted to underscores)

If you want the full namespace with the `group` then add the flag `+group-in-ns` to the end of the command line.
In this case the command:

```
clj -A:new  https://github.com/omnyway-labs/chromex-shadow-template@8aca66a0826036278cc78ab2c5d0a800b094d8fe omnyway-labs/test-project +group-in-ns
```

will create the namespace `omnyway_labs.test_project` and the `src` path to the
code will be `src/omnyway_labs/test_project/*.cljs`

> __NOTE:__ If your have dashes or underscores in the project group / name.
> Javascript freaks out, so this template will convert dashes to underscores.
> I.E. if you use the project name `omnyway-labs/test-project`, it will turn the
> namespace into `test_project` or `omnyway_labs.test_project` 

### The `data` map that is passed into the renderer looks like:

```clj
{:date 2020-01-29, 
  :group omnyway-labs, 
  :name test-project, 
  :sanitized test_project, 
  :year 2020, 
  :template-nested-dirs {{nested-dirs}}, 
  :artifact test-project, 
  :developer Rberger, 
  :nested-dirs test_project, 
  :version 0.1.0-SNAPSHOT, 
  :namespace test_project, 
  :user rberger, 
  :raw-name omnyway-labs/test-project}
```

## Authors

[Isaac "Icylisper" Praveen](https://github.com/icylisper)

[Robert J. Berger](https://github.com/rberger)

Based on [Chromex Example Shadow](https://github.com/binaryage/chromex/tree/master/examples/shadow) by [Antonin Hildebrand (darwin)](Antonin Hildebrand)

## License
MIT License
Copyright © 2020 Omnyway, Inc.

