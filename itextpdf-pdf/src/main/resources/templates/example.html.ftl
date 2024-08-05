<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>社区矫正实地查访情况登记表</title>
    <style>
        body { font-family: Arial, sans-serif; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<table>
    <tr>
        <th>矫正机构:</th>
        <td>${correctiveInstitution}</td>
    </tr>
</table>
<tr>
    <th>查访对象姓名:</th>
    <td>${name}</td>
</tr>
<tr>
    <th>性别:</th>
    <td>${sex}</td>
</tr>
<tr>
    <th>矫正类别:</th>
    <td>${correctiveType}</td>
</tr>
<tr>
    <th>查访对象姓名:</th>
    <td>${correctiveObjectName}</td>
</tr>
<tr>
    <th>查访时间:</th>
    <td>${correctiveTime_1}</td>
</tr>
<tr>
    <th>查访场所:</th>
    <td>${correctivePlace}</td>
</tr>
<tr>
    <th>工作人员:</th>
    <td>${correctiveWorker}</td>
</tr>
<tr>
    <th>走访事由:</th>
    <td>${correctiveReason}</td>
</tr>
<tr>
    <th colspan="2">查访情况记录:</th>
</tr>
<tr>
    <td colspan="2" style="border-top: none; padding-top: 0;">
        ${correctiveRecord}
    </td>
</tr>
<tr>
    <th>查访对象签字:</th>
    <td>${correctiveObjectSignature}</td>
</tr>
<tr>
    <th>工作人员签字:</th>
    <td>${correctiveWorkerSignature}</td>
</tr>
<tr>
    <th>时间:</th>
    <td>${correctiveTime}</td>
</tr>

</table>
</body>
</html>