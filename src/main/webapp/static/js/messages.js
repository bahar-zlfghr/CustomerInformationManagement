const grant_condition_name_min_length = 3;
const loan_type_name_min_length = 5;
const loan_type_interest_rate_min_value = 0;
const loan_type_interest_rate_max_value = 100;
const legal_customer_company_name_min_length = 3;
const real_customer_first_name_min_length = 3;
const real_customer_last_name_min_length = 3;
const real_customer_father_name_min_length = 3;
const real_customer_national_code_length = 10;
const legal_customer_economic_code_length = 12;
const date_pattern = /^[1-4]\d{3}\/((0[1-6]\/((3[0-1])|([1-2][0-9])|(0[1-9])))|((1[0-2]|(0[7-9]))\/(30|31|([1-2][0-9])|(0[1-9]))))$/;

const grant_condition_name_error = 'نام شرط اعطاء را وارد کنید';
const grant_condition_name_min_length_error = 'حداقل طول نام شرط اعطاء ' + grant_condition_name_min_length + ' است';
const grant_condition_min_period_error = 'حداقل مدت قرارداد را وارد کنید';
const grant_condition_negative_min_period_error = 'حداقل مدت قرارداد باید بزرگتر از 0 باشد';
const grant_condition_max_period_error = 'حداکثر مدت قرارداد را وارد کنید';
const grant_condition_negative_max_period_error = 'حداکثر مدت قرارداد باید بزرگتر از 0 باشد';
const grant_condition_min_amount_error = 'حداقل مبلغ قرارداد را وارد کنید';
const grant_condition_negative_min_amount_error = 'حداقل مبلغ قرارداد باید بزرگتر از 0 باشد';
const grant_condition_max_amount_error = 'حداکثر مبلغ قرارداد را وارد کنید';
const grant_condition_negative_max_amount_error = 'حداکثر مبلغ قرارداد باید بزرگتر از 0 باشد';
const grant_condition_min_max_period_error = 'حداکثر مدت قرارداد باید از حداقل مدت قرارداد بزرگتر باشد';
const grant_condition_min_max_amount_error = 'حداکثر مبلغ قرارداد باید از حداقل مبلغ قرارداد بزرگتر باشد';

const loan_type_min_grant_conditions_error = 'هر نوع تسهیلات حداقل باید یک شرط اعطاء داشته باشد';
const loan_type_name_error = 'نام نوع تسهیلات را وارد کنید';
const loan_type_name_min_length_error = 'حداقل طول نام نوع تسهیلات ' + loan_type_name_min_length + ' است';
const loan_type_interest_rate_error = 'نرخ سود را وارد کنید';
const loan_type_interest_rate_value_error ='نرخ سود باید بین ' + loan_type_interest_rate_min_value + ' تا ' + loan_type_interest_rate_max_value + ' باشد';

const loan_file_customer_no_error = 'شماره مشتری را وارد کنید';
const loan_file_real_customer_recovery_error = 'ابتدا اطلاعات مشتری مورد نظر را بازیابی کنید';
const loan_file_loan_type_error = 'نوع تسهیلات را انتخاب کنید';
const loan_file_period_error = 'مدت قرارداد را وارد کنید';
const loan_file_negative_period_error = 'مدت قرارداد باید بزرگتر از 0 باشد';
const loan_file_amount_error = 'مبلغ قرارداد را وارد کنید';
const loan_file_negative_amount_error = 'مبلغ قرارداد باید بزرگتر از 0 باشد';

const legal_customer_company_name_error = 'نام شرکت را وارد کنید';
const legal_customer_company_name_min_length_error = 'حداقل طول نام شرکت ' + legal_customer_company_name_min_length + ' است';
const legal_customer_registration_date_error = 'تاریخ ثبت شرکت را وارد کنید';
const legal_customer_registration_date_not_valid_error = 'تاریخ ثبت شرکت معتبر نیست';
const legal_customer_economic_code_error = 'کد اقتصادی مشتری حقوقی را وارد کنید';
const legal_customer_economic_code_length_error = 'کد اقتصادی مشتری حقوقی باید ' + legal_customer_economic_code_length + ' رقمی باشد';

const real_customer_first_name_error = 'نام مشتری را وارد کنید';
const real_customer_first_name_min_length_error = 'حداقل طول نام مشتری ' + real_customer_first_name_min_length + ' است';
const real_customer_last_name_error = 'نام خانوادگی مشتری را وارد کنید';
const real_customer_last_name_min_length_error = 'حداقل طول نام خانوادگی مشتری ' + real_customer_last_name_min_length + ' است'
const real_customer_father_name_error = 'نام پدر مشتری را وارد کنید';
const real_customer_father_name_length_error = 'حداقل طول نام پدر مشتری ' + real_customer_father_name_min_length + ' است';
const real_customer_birth_date_error = 'تاریخ تولد شرکت را وارد کنید';
const real_customer_birth_date_not_valid_error = 'تاریخ تولد شرکت معتبر نیست';
const real_customer_national_code_error = 'کد ملی مشتری را وارد کنید';
const real_customer_national_code_length_error = 'کد ملی مشتری باید ' +  + ' رقمی باشد'
const real_customer_national_code_not_valid_error = 'کد ملی مشتری معتبر نیست'