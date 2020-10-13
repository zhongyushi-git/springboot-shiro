$(function () {

    var table;
    layui.use('table', function () {
        table = layui.table;

    //加载table
    table.render({
        elem: '#dataTable'
        ,height: 500
        ,url: '/api/permission/list/' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'id', title: 'ID', width:80, fixed: 'left',sort: true}
            ,{field: 'permissionsName', title: '权限名',sort: true}
            ,{field: 'permissionsCode', title: '权限编码', sort: true}
        ]]
    });
    })

})
