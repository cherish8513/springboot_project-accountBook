var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-deposit').on('click', function () {
            _this.deposit();
        });

        $('#btn-login-withdraw').on('click', function () {
            _this.login_withdraw();
        });

        $('#btn-login-deposit').on('click', function () {
            _this.login_deposit();
        });


        $('#btn-withdraw').on('click', function () {
            _this.withdraw();
        });

        $('#btn-lookup').on('click', function () {
            _this.lookup();
        });


    },
    save : function () {
        var data = {
            email: $('#email').val(),
            balance: $('#balance').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/accountBook',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 완료되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    deposit : function () {
            var data = {
                email: $('#email').val(),
                money: $('#money').val()
            };

            $.ajax({
                type: 'PUT',
                url: '/api/deposit',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('입금이 완료되었습니다.');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

    login_deposit : function () {
            var data = {
                money: $('#money').val()
            };

            $.ajax({
                type: 'PUT',
                url: '/api/login/deposit',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('입금이 완료되었습니다.');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

    withdraw : function () {
            var data = {
                email: $('#email').val(),
                money: $('#money').val()
            };

            $.ajax({
                type: 'PUT',
                url: '/api/withdraw',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('출금이 완료되었습니다.');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

    login_withdraw : function () {
            var data = {
                money: $('#money').val()
            };

            $.ajax({
                type: 'PUT',
                url: '/api/login/withdraw',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('출금이 완료되었습니다.');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

    lookup : function () {
        var form = document.querySelector('form');
        var formData = new FormData(form);
        window.location.href = '/accountBook/lookup?email='+formData.get('email');
    }
};

main.init();