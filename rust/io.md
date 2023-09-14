
### input

```rust
fn main() {
    // input all lines
    let mut input = String::new();
    io::stdin().read_to_string(&mut input).unwrap();
    
    // split & parse int
    let mut tokens = input.split_ascii_whitespace();
    let token = tokens.next().unwrap();
    let number: i32 = token.parse().unwrap();
    
    // parse in iteration
    let mut numbers = input.split_ascii_whitespace().map(str::parse).flatten();
    let a: usize = numbers.next().unwrap();
    let b = numbers.next().unwrap();
    let c = numbers.next().unwrap();
}
```

### output
```rust
use std::fmt::Write;

fn main() {
    let mut output = String::new();

    writeln!(output, "{} + {} = {}", 1, 2, 1 + 2).unwrap();

    // print required
    print!("{}", output);
}
```