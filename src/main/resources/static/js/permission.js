let table
const baseApi = "/api/permission"
var parentData = { id: null, index: null, baseApi, }

$(function() {

    layui.use('table', function() {
        table = layui.table;

        //加载table
        table.render({
            elem: '#dataTable',
            height: 540,
            url: baseApi + '/list', //数据接口
            // where: {  }, //传递额外参数
            page: true, //开启分页
            id: 'tableReload',
            defaultToolbar: ['print', 'exports'], //设置工具栏显示的图标
            toolbar: 'defaultToolbar', //开启工具栏
            cols: [
                [ //表头
                    { field: 'id', title: 'ID', width: 80, fixed: 'left', sort: true },
                    { field: 'permissionsName', title: '权限名', sort: true },
                    { field: 'permissionsCode', title: '权限编码', sort: true },
                    { fixed: 'right', title: '操作', width: 165, align: 'center', toolbar: '#barDemo' }
                ]
            ],
            //加载完成设置样式
            done() {
                $("table th").css("text-align", "center")
            }
        })

        //监听行工具事件
        table.on('tool(test)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            const data = obj.data //获得当前行数据
            const layEvent = obj.event //获得 lay-event 对应的值
            if (layEvent === 'del') {
                layer.confirm('确定要删除此数据吗？', function(index) {
                    layer.close(index);
                    //向服务端发送删除指令
                    deleteById(data.id)
                });
            } else if (layEvent === 'edit') {
                editData(1, data.id)
            }
        });
    })


})

//表格重载
function reloadTable() {
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
function editData(status, id) {
    parentData.id = id
    const statusMap = ['添加', '修改']
    parentData.index = layer.open({
        type: 2,
        btn: false,
        area: ['340px', '190px'],
        title: [statusMap[status] + '权限信息', '15px'],
        content: 'edit.html'
    })
}
//删除数据
function deleteById(id) {
    post(baseApi + "/del", { id }, function(data) {
        if (data.status) {
            layer.msg("删除成功");
            reloadTable()
        } else {
            layer.msg("删除失败");
        }
    })
}
