package hibernate.filter.example

class Foo {

    String name
    Boolean enabled

    static hasMany = [bars: Bar]

    static hibernateFilters = {
        fooEnabledFilter(condition: 'enabled=true', default: true, aliasDomain: 'EnabledFoo')
        barEnabledFilter(collection: 'bars', condition: 'enabled=true', default: true)
        fooNameFilter(condition: ':name = name', types: 'string')
        closureDefaultFilter(condition: 'enabled=true', default: { -> false })
        inListFilter(condition: '(organisation_id = :oragnisationId or organisation_id in (:organisationIds))',
                default: false,
                paramTypes: 'long, long')
        multipleUseParamFilter(condition: 'id > :avoid or id < :avoid', types: 'long', default: false)
    }

    String toString() {
        "Foo($id):$name:$enabled"
    }
}