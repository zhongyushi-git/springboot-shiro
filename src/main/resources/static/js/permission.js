let table
let parentData = { id: null, index: null }
$(function() {

    layui.use('table', function() {
        table = layui.table;

        //加载table
        table.render({
            elem: '#dataTable',
            height: 500,
            url: '/api/permission/list', //数据接口
            // where: {  }, //传递额外参数
            page: true, //开启分页
            id: 'tableReload',
            cols: [
                [ //表头
                    { field: 'id', title: 'ID', width: 80, fixed: 'left', sort: true }, { field: 'permissionsName', title: '权限名', sort: true }, { field: 'permissionsCode', title: '权限编码', sort: true }
                ]
            ],
            //加载完成设置样式
            done(res, curr, count) {
                $("table th").css("text-align", "center")
            }
        });
    })


})

//表格重载
function readloadTable() {
    const name = $("input[name='name']").val()
    const code = $("input[name='code']").val()
    table.reload('tableReload', {
        where: { name, code },
        page: {
            curr: 1, //设置当前页面为第一页
        },
    }, 'data')
}
//编辑数据
function editData(status) {
    parentData.id = null
    const statusMap = ['添加', '修改']
    parentData.index = layer.open({
        type: 2,
        btn: false,
        area: ['340px', '190px'],
        title: [statusMap[status] + '权限信息', '15px'],
        content: 'edit.html'
    })
}