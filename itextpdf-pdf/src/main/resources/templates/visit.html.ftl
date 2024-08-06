<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>社区矫正实地查访情况登记表</title>
    <style>
        .center-text {
          text-align: center;
        }

        .large-cell {
             width: 70%; /* 为需要较大空间的单元格设置宽度 */
        }

        body {
          font-family: Arial, sans-serif;
        }

        table {
          width: 100%;
          height: auto;
          border-collapse: collapse;
        }

        td {
          border: 1px solid #ddd;
          padding: 8px;
          text-align: left;
        }
    </style>
</head>
<body>
  <div class='center-text'>社区矫正实地查访情况登记表</div>
  <div>
    矫正机构:  ${correctiveInstitution}
  </div>

  <div>
    <table>
      <tr>
          <td>查访对象姓名:</td> <td>${visitObjectName}</td>
          <td>性别:</td> <td>${visitObjectSex}</td>
          <td>矫正类别:</td> <td>${correctiveType}</td>
      </tr>
      <tr>
          <td>查访时间:</td> <td>${visitTime}</td>
          <td>查访场所:</td> <td>${visitPlace}</td>
          <td>工作人员:</td> <td>${staffMember}</td>
      </tr>
      <tr>
        <td>走访事由:</td> <td colspan='5'>${visitReason}</td>
      </tr>
    </table>
  </div>

  <div>
    <table>
      <tr>
        <td style="width: 5px; text-align: center;">查访情况记录</td>
        <td>
          <div class="large-cell">
            <div>
              <#list visitReasonList as item>
                  <p>${item}</p>
               </#list>
            </div>
            <div>
                <p>
                  <span style='margin: 1px;'>查访对象签字: </span> <span>${visitObjectSignature}</span>
                  <span span style='margin: 30px;'>工作人员签字: </span> <span>${staffMemberSignature}</span>
                </p>
                <p>
                  <span style='margin: 1px;'>时间:</span>  <span>${attach_1}</span>
                  <span style='margin: 165px;'>时间:</span> <span >${attach_2}</span>
                </p>
            </div>
          </div>
        </td>
      </tr>
    </table>
  </div>
</body>
</html>