# include "iostream"

struct A
{
	A ()
	{
		std::cout << "First Came here" << std::endl;
	}
};

A a;

int before_main()
{
    std::cout << "Second before main" << std::endl;
    return 0;
}

static int n = before_main();

#define NEWTAS 12

int main ()
{
	std::cout << "Main\n";
	std::cout << NEWTAS << std::endl;
	return 0;
}
