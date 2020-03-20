# dumb demo application that invokes another demo application via rest

```
curl --request GET --url http://localhost:8081/<planset>
```

By default there are these two plan sets: 
1. `washing-a-dog`
2. `research`

There's an application property that can be set via environment variable, which must point to the other rest service:
* `PLAN_SETS_URI` the default 