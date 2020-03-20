# dumb demo application that invokes another demo application via rest

```
curl --request GET --url http://localhost:8081/<planset>
```

By default there are these two plan sets: 
1. `washing-a-dog`
2. `research`

This application requires externalized spring configuration to override the dev defaults for the following to properties:
1. `PLANSETS_URI` -- must point to the route for the `plan-sets` service
1. `SERVER_PORT` -- must specify `8080` for openshift (it doesn't like the default of `8081`)