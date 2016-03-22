class PeselValidate:
    'Klasa sprawdzająca poprawnośc wprowadzonego numeru PESEL'

    def __init__(self, str1):
        self.PESEL=str1

    def validate(self):
        PESEL_list=[]
        for i in str(self.PESEL):
            PESEL_list.append(int(i))
        control_sum = 1*PESEL_list[0] + 3*PESEL_list[1] + 7*PESEL_list[2] + 9*PESEL_list[3] + 1*PESEL_list[4] + 3*PESEL_list[5] + 7*PESEL_list[6] + 9*PESEL_list[7] + 1*PESEL_list[8] + 3*PESEL_list[9]
        r=control_sum%10
        control_number=0
        if r==0:
            control_number=0
        else:
            control_number=10-r
        
        return control_number==PESEL_list[10]


PESEL_input=input("Podaj nr PESEL: ")
p1=PeselValidate(PESEL_input)
print(p1.validate())
