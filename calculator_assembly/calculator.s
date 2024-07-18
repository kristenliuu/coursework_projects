#
# Usage: ./calculator <op> <arg1> <arg2>
#

# Make `main` accessible outside of this module
.global main

# Start of the code section
.text

# int main(int argc, char argv[][])
main:
  # Function prologue
  enter $0, $0

  # Variable mappings:
  # op -> %r12
  # arg1 -> %r13
  # arg2 -> %r14
  movq 8(%rsi), %r12  # op = argv[1]
  movq 16(%rsi), %r13 # arg1 = argv[2]
  movq 24(%rsi), %r14 # arg2 = argv[3]


  # Hint: Convert 1st operand to long int
  movq %r13, %rdi
  call atol
  movq %rax, %r13
  
  # Hint: Convert 2nd operand to long int
  movq %r14, %rdi
  call atol  
  movq %rax, %r14

  # Hint: Copy the first char of op into an 8-bit register
  # i.e., op_char = op[0] - something like mov 0(%r12), ???
  mov 0(%r12), %al

  # if (op_char == '+') {
  #   ...
  # }
  # else if (op_char == '-') {
  #  ...
  # }
  # ...
  # else {
  #   // print error
  #   // return 1 from main
  # }

  #addition
  cmp $43, %al
  je add

  #subtraction
  cmp $45, %al
  je subtract

  #multiplication
  cmp $42, %al
  je multiply

  #division
  cmp $47, %al
  je divide
 
  #invalidOp 
  jmp invalid

  # Function epilogue

  add:
  movq %r13, %rax
  addq %r14, %rax
  mov %rax, %rsi
  mov $format, %rdi
  call printf
  leave
  ret

  subtract:
  movq %r13, %rax
  sub %r14, %rax
  mov %rax, %rsi
  mov $format, %rdi
  call printf
  leave
  ret 

  multiply:
  movq %r13, %rax
  imulq %r14, %rax
  mov %rax, %rsi
  mov $format, %rdi
  call printf
  leave
  ret

  divide:
  cmp $0, %r14
  je invalid_divisor
  mov %r13, %rax
  cqo
  idiv %r14
  mov %rax, %rsi
  mov $format, %rdi
  call printf
  leave
  ret
  
  invalid:
  mov $unknown_op, %rdi
  mov $0, %al 
  call printf
  leave
  ret

  invalid_divisor:
  mov $divisor_error, %rdi
  mov $0, %al
  call printf
  leave
  ret


# Start of the data section
.data

format: 
  .asciz "%ld\n"

unknown_op:
  .asciz "Unknown Operation\n"

divisor_error:
  .asciz "Divisor Cannor Be 0\n"
